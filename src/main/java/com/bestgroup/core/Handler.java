package com.bestgroup.core;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import com.bestgroup.core.exception.HandlerException;

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
		// Also does nothing...
	}

	public Result handle(Payload payload) throws HandlerException{
		return this.nextHandler != null ? this.nextHandler.handle(payload) : payload;
	}

}
