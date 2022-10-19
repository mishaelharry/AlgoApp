# AlgoApp




#System Design for Mobile Banking Service
1. Gathering use case, constraits
    * Who is going to use this system?
    * How are they going to use it?
    * How many users?
    * What does the system do?
    * Inputs and Output of the System?
    * How much data do we expect to handle?
    * What is the request/second (1mil/s or 10/s)
    * Read/Write ratio
  
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
