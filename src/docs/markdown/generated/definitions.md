## Definitions
### BannerResponse
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|asset|图片或视频地址|true|string||
|link|图片或视频跳转地址|true|string||
|offlineTime|失效时间|true|string (date-time)||
|onlineTime|生效时间|true|string (date-time)||


### ConfigResponse
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|ads|广告Banner列表|false|BannerResponse array||
|forceUpdate|是否强制升级|true|boolean||
|forceUpdateWebview|强制升级引导Webview|true|string||
|needUpdate|是否需要升级|true|boolean||
|servers|vpn服务器列表|true|ServerResponse array||
|updateInfo|升级信息|true|string||
|userInfo|当前登录用户信息|false|VipUserInfoResponse||


### ConnectAuthResponse
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|password|VPN拨号密码|true|string||
|secret|VPN拨号Secret|true|string||
|username|VPN拨号用户名|true|string||


### ServerResponse
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|cnt|服务器当前连接加权参数|true|integer (int32)||
|ip|服务器IP|true|string||
|name|服务器名称|true|string||
|rcnt|服务器当前真实连接数|true|integer (int32)||


### VipUserInfoResponse
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|expireDate|用户套餐截止日期|true|string (date-time)||
|mobile|用户手机号|true|string||
|token|用户当前登录Token|true|string||


