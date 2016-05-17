## Paths
### 获取服务器及当前用户信息
```
GET /config.php
```

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|ConfigResponse|


#### Consumes

* */*

#### Produces

* application/json;charset=UTF-8

#### Tags

* vpn-controller

### 获取用户VPN连接账户
```
GET /connect.php
```

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|ConnectAuthResponse|


#### Consumes

* */*

#### Produces

* application/json;charset=UTF-8

#### Tags

* vpn-controller

### 获取用户登录验证码图片
```
GET /user/login-captcha.php
```

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|No Content|


#### Consumes

* */*

#### Produces

* image/png

#### Tags

* captcha-controller

### 用户登录
```
POST /user/login.php
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|mobile|手机号|true|string||
|QueryParameter|code|验证码|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|VipUserInfoResponse|


#### Consumes

* */*

#### Produces

* application/json;charset=UTF-8

#### Tags

* user-controller

### 短信发送用户登录验证码
```
POST /user/send-login-mcode.php
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|mobile|手机号|true|string||
|QueryParameter|captcha|图片验证码|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|EmptyResponse|


#### Consumes

* */*

#### Produces

* application/json;charset=UTF-8

#### Tags

* user-controller

### 语音发送用户登录验证码
```
POST /user/send-login-pcode.php
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|mobile|手机号|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|EmptyResponse|


#### Consumes

* */*

#### Produces

* application/json;charset=UTF-8

#### Tags

* user-controller

