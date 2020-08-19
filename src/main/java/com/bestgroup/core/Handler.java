package com.bestgroup.core;

public interface Handler<C, P> {

	public P handle(C consumable);

}
