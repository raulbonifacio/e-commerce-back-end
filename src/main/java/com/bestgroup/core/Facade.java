
package com.bestgroup.core;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import com.bestgroup.core.exception.FacadeException;
import com.bestgroup.core.exception.HandlerException;

@Stateless
public interface Facade {

	public Result create(DomainEntity entity) throws FacadeException, HandlerException;

	public Result update(DomainEntity entity) throws FacadeException, HandlerException;

	public Result delete(DomainEntity entity) throws FacadeException, HandlerException;

	public Result read(DomainEntity entity) throws FacadeException, HandlerException;
}
