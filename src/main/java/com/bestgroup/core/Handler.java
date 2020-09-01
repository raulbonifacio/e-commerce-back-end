package com.bestgroup.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Handler {

	public static Handler chain(List<Function<Handler, Handler>> handlerFactoryChain) {

		Collections.reverse(handlerFactoryChain);

		Handler handlerChain = new Handler() {
			// Does nothing...
		};

		for (Function<Handler, Handler> nextToBeChained : handlerFactoryChain) {
			handlerChain = nextToBeChained.apply(handlerChain);
		}

		return handlerChain;
	}

	protected Handler nextHandler;

	public Handler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public Handler() {

	}

	public Result handle(Payload payload) {
		return this.nextHandler != null ? this.nextHandler.handle(payload) : payload;
	}

}
