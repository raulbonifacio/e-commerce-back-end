package com.bestgroup.core;

public interface Facade<C, P, O> {

	public P dispatch(O option, C cosumable);

}
