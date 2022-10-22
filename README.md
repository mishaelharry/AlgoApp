# AlgoApp




#System Design for Mobile Banking Service
1. Gathering use case, constraits
    a. Tiny Url System
      * Get clarity of the system to be designed? create shorhen url and retrieve long url from shorten
      * how long should the system be in service? 10 years
      * Should we have an expiry time for each generated tiny URL? minutes or optional
      * Should the user be registered to the website/service for creating a tiny URL? optional
      * Should the base url be customizable?
      * Inputs and Output of the System?
         - createShortUrl(userToken: optional, longUrl, ExpiryTime:optional) -> ShortUrl
         - getLongUrl(shortUrl) - LongUrl
         - login(userName, password) -> userToken
      * how much traffic should we expect? 1million monthnly / 1billion urls
      * Read/Write ratio? read heavy

2. High-level design
    a. Tiny Url Service
      * Client
      * Web server
      * Load balancer
      * UrlShortenService
      * Caching
      * Database (SQL or Mongodb)
      * Loging (Elasticsearch, Logstash, and Kibana)
    
    b. Mobile Banking Service
      * Client
      * Web server
      * Load balancer
      * API Gateway
      * Discovery service
      * Config Service
      * Session Service
      * Customer Service
      * Transfer Service
      * Bill payment Service
      * Database (SQL or Mongodb)
      * Caching
      * Loging (Elasticsearch, Logstash, and Kibana)
  
3. Core components desgin
    a. Tiny Url Service
      * UrlShortenService - For every request that hits the webservice, the load balance distribute request cross all services. When create short url request enters a service, a random digit aplhanemric generated as a key to map the long url. For each write the service checks if the randomly generated key is already present in the db or not, in case the key is present, another key is generated.     
    b. Mobile Banking Service
      * Customer Service - discuss authentication, security and session management
      * Transfer Sevice - discuss about external api calls and circuit breaking pattern
      * Bill payment - discuss about bill processing, reversal and requery
      * Database - discuss about SQL or Mongodb tradeoffs

4. Scaling your system
    a. Tiny Url
      * Scalability: It would be difficult to scale the system, the generation of random key and writing to DB are highly coupled together (decouple key generation to another service).
      * Latency: There can be multiple trials before the API server is able to find a non-existing key in the DB(Get key from a pool of key). Also are every read request to get the longUrl would be hiting the db (Caching).
      * SQL/No SQL: for checking if the key exists SQL DB has commands like “IF NOT EXISTS”. While in NO SQL there are no optimized commands to use but you can still search the whole table to see if the key exists. So this solution might perform better for a SQL DB.
      * Horzital scaling: We would run multiple instance of the UrlShortenService
        ![image](https://user-images.githubusercontent.com/29702577/197355040-f80e1f1a-e8e0-4b3c-9bb4-b50804664f91.png)

    b. Mobile banking
      * Load balancer - incoming request to multiple instances
      * Caching - duplicate transaction, session manage
      * DB Sharding
      * Horzital scaling



Database/Storage
    1. Caches - Redis, Memcahed
    2. File system storage - Amazon S3
    3. Text search engine - Elasticsearch
    4. Data warehouse - Hadoop
    5. Database -
        * MySql - If that Structured data and if we need our transactions to be atomic, consistent, isolated, and durable (ACID)
        * MongoDB, Cassandra, HBase, Couchbase - if your data lacks a structure, it cannot be represented as a table. 
        * MongoDB, Couchbase - If we have a vast variety of attributes in our data and a vast variety of queries.
        * Cassandra, HBase - If we have to work on an extremely large scale but have few types of queries we need to run
