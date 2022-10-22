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
    * Customer Service - discuss authentication, security and session management
    * Transfer Sevice - discuss about external api calls and circuit breaking pattern
    * Bill payment - discuss about bill processing, reversal and requery
    * Database - discuss about SQL or Mongodb tradeoffs

4. Scaling your system
    * Load balancer - incoming request to multiple instances
    * Caching - duplicate transaction, session manage
    * DB Sharding
    * Horzital scaling
