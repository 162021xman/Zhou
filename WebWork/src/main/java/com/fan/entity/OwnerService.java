package com.fan.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import domain.owner;

@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.INTERFACES)
public class OwnerService implements OwnerRepo{

	@Override
	public List<owner> getAllOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public owner getOwner(String ownerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public owner getLogin(String ownerid, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<owner> getOwnerInParam(String ownerid, String ownername, String ownertel, String wuyeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int InsertOwner(String ownerid, String password, String ownername, String ownertel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DelOwner(String ownerid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateOwner(String ownerid, String password, String ownername, String ownertel) {
		// TODO Auto-generated method stub
		return 0;
	}

}
