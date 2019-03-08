## Android 组件间通信框架 ApiManager

## 项目介绍

ApiManager 是一款简单易用、安全高效组件间通信框架，支持组件间以暴露接口提供服务的方式进行通信，帮助组件化架构的实现。

## 设计特点
#### 1. 自动注册

使用注解在编译阶段生成服务接口与实现的映射注册帮助类，获取服务时自动使用帮助类完成注册，不必手动调用注册方法。

#### 2. 按需加载

第一次获取服务时，用反射生成映射注册帮助类的实例，再返回实现的实例。

#### 3. 空安全

无服务实现注册时，使用空对象模式 + 动态代理的设计提前暴露调用错误，防止空指针异常。

## 使用指南

这里主要以 *example* 中的代码进行说明

##### 1. 在基础组件中配置，见 :example:base Module



##### 2. 在基础组件中定义接口，如 IUserApi.java，见 :example:base Module

```java
package com.moer.base;

import android.content.Context;
import com.moer.api.IApi;

public interface IUserApi extends IApi {
    void login(Context context);

    String getUserDescription();
}
```

##### 3. 在提供服务的组件中配置，见 :example:user Module




##### 4. 在提供服务的组件中定义实现，注意使用 ApiImpl 注解，见 :example:user Module

```java
package com.moer.module;

import android.content.Context;
import android.widget.Toast;
import com.moer.api.ApiImpl;
import com.moer.base.IUserApi;

@ApiImpl(IUserApi.class)
public class UserApiImpl implements IUserApi {
    @Override
    public void login(Context context) {
        Toast.makeText(context, "user module login() called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUserDescription() {
        return "user's description from user module";
    }
}
```

##### 5. 使用服务的组件中获取实例，见 :example:app_or_library Module


```java
IUserApi userApi = ApiManager.getInstance().getApi(IUserApi.class);
```

​    **5.1. 调用不需要返回值的实例方法**

```java
userApi.login(getContext());
```

​    **5.2. 调用需要返回值的实例方法，需要先调用 isPresent() 判断是否为空对象**

```java
if (userApi.isPresent()) {
    Toast.makeText(getContext(), userApi.getUserDescription(), Toast.LENGTH_SHORT).show();
}
```

##### 6. 混淆配置

```
-keep public class * implements com.moer.api.** { *; }
```

## License

```
Copyright xingjiyuan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

