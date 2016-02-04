package com.mosesmansaray.kata.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
	* Created by moses.mansaray on 02/02/2016.
	*/
public class IOCContainer {

		public <T> T get(Class<T> fooClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

				Constructor<?>[] constructors = fooClass.getClass().getConstructors();
				Constructor currentWithMostCount = getConstructor(constructors);
				List<T> constructorParameters = new ArrayList<>();
				Class[] parameterTypes = null;

				if (currentWithMostCount != null) {
						parameterTypes = currentWithMostCount.getParameterTypes();
				}

				if (parameterTypes != null) {
						for (Class parameterType : parameterTypes) {
								constructorParameters.add((T) parameterType.newInstance());
						}

						return (T) fooClass.getClass().getDeclaredConstructor(parameterTypes).newInstance();
				}
			return fooClass.newInstance();
		}

		private Constructor getConstructor(Constructor<?>[] constructors) {
				Constructor currentWithMostCount = null;
				for (Constructor<?> constructor : constructors) {
						constructor.getParameterCount();
						if (null != currentWithMostCount || constructor.getParameterCount() > currentWithMostCount.getParameterCount()) {
								currentWithMostCount = constructor;
						}
				}
				return currentWithMostCount;
		}
}
