
package com.bestgroup.core;

import java.util.Map;

public interface Payload<E, R, I> extends Result<E, R> {

	public Map<String, I> getInput();

}
