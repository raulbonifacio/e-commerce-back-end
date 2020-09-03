package com.bestgroup.core;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import com.bestgroup.core.exception.HandlerException;

public abstract class Handler {

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

	protected Handler next;

	public Handler() {
		// Does nothing...
	}

	public Handler(Handler next) {
		this.next = next;
	}

	public Result handle(Payload payload) throws HandlerException {
		return this.next != null ? this.next.handle(payload) : payload;
	}

}
