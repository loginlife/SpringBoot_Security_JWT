# Spring Boot 整合 JWT

使用 `Spring Boot` 和 `JWT` 实现登录验证，传统模式使用 session 的方式，即客户端请求服务端，服务端生成一个 session，然后返回一个 sessionID 给客户端，客户端将 sessionID 保存到本地，下次提交请求时一起提交。

JWT 方式则服务端不需要保存 session，客户端请求服务端时，服务端将根据一些信息生成一个 token，该token中包含了用户的一些信息（非敏感信息），客户端请求时将该 token 带上，服务端使用密钥进行验证和解密。

## jwt_demo1

该项目使用 `Spring Boot + Freemarker + JWT` 实现登录验证，后端使用 `Apache Ignite` 内存数据库来临时存放用户信息（可以使用数据库代替）。主要包含如下几个页面：

* 注册页面（注册临时用户）
* 登录页面（用户登录，获取 token，把token保存到cookie）
* 使用收到的token请求受保护资源
