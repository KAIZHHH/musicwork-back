package com.kai.shiro.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
3、JwtToken
​ 上面我们通过JwtUtil的getJwtToken就可以生成Jwt规范的tokenA字符串
 首先要清楚这个tokenA就是需要发送给客户端进行保存的token。
 而在前面的区别我们说到Shiro还需要token可以进行认证，
 可以采用Shiro自带的token去进行认证，也可以使用我们这个tokenA进行认证（在controller中说明），
 这里我们对这个tokenA再利用。

​ 但是由于Shiro不能识别身为字符串的tokenA，
 所以需要对其进行一下封装，也就是实现下Shiro能够识别的token接口。
 */

/**
 * @author: zhk
 * 自定义的shiro接口token，可以通过这个类将string的token转型成AuthenticationToken，可供shiro使用
 * 注意：需要重写getPrincipal和getCredentials方法，因为是进行三件套处理的，
 * 没有特殊配置shiro无法通过这两个方法获取到用户名和密码，需要直接返回token，之后交给JwtUtil去解析获取。
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
