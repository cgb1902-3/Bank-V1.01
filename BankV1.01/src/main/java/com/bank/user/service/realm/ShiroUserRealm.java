package com.bank.user.service.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bank.user.dao.SysUserDao;
import com.bank.user.entity.SysUserAdmin;

@Service
public class ShiroUserRealm extends AuthorizingRealm{
	@Autowired
	private SysUserDao sysUserDao;
	
	/** 设置凭证匹配器(此方法用于告诉认证管理器
	 * 采用什么加密算法对用户输入密码进行加密)
	 */
	@Override
	public void setCredentialsMatcher(
			CredentialsMatcher credentialsMatcher) {
		//构建CredentialsMatcher对象
		HashedCredentialsMatcher hcm=
				new HashedCredentialsMatcher();
		//设置加密算法
		hcm.setHashAlgorithmName("MD5");
		//设置加密次数
		hcm.setHashIterations(1);
		super.setCredentialsMatcher(hcm);
	}

	
	/**
	 * 通过此方法完成认证数据的获取及封装,系统
	 * 底层会将认证数据传递认证管理器，由认证
	 * 管理器完成认证操作。
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.从token中获取用户名(用户页面输入)
		UsernamePasswordToken upToken=
				(UsernamePasswordToken)token;
		String username=upToken.getUsername();
		//2.基于用户名从数据库查询用户信息
		SysUserAdmin user = 
				sysUserDao.findUserByUserName(username);
		//3.判定用户是否存在
		if (user==null)
			throw new UnknownAccountException();
		
		//5.封装用户信息
		ByteSource credentialsSalt=
				ByteSource.Util.bytes(user.getSalt());
		//记住：构建什么对象要看方法的返回值
		SimpleAuthenticationInfo info=
				new SimpleAuthenticationInfo(
						user,//principal (表示身份信息)
						user.getPassword(),//hashedCredentials(已加密的)
						credentialsSalt, //credentialsSalt
						getName());//realName
		//6.返回封装结果
		return info;//返回值会传递给认证管理器(后续
		//认证管理器会通过此信息完成认证操作)
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
}
