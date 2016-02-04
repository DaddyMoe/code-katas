package com.mosesmansaray.kata.ioc;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
	* source : https://github.com/davidwhitney/CodeDojos/tree/master/IoCContainer
	*/
public class IOCContainerTest {

		private IOCContainer iocContainer;


		@Before
		public void setUp() throws Exception {
				iocContainer = new IOCContainer();
		}

		//Story 1 - Create a class with no constructor parameters
		@Test
		public void shouldReturnExpectedInstanceOfObject() throws InstantiationException, IllegalAccessException,
						NoSuchMethodException, InvocationTargetException {
				Foo foo = iocContainer.get(Foo.class);
				assertTrue("should not be null", foo != null);
		}

		//Story 2 - Create a class with constructor parameters
		@Test
		public void shouldReturnExpectedInstanceOfObjectWithGivenProperty() throws InstantiationException,
						IllegalAccessException, NoSuchMethodException, InvocationTargetException {
				Foo foo = new Foo("bar");
				iocContainer.get(foo.getClass());
				assertTrue("should not be null", foo != null);
				assertEquals("should not be null", "bar", foo.getFoo());

		}

		//Story 2 - Create a class with constructor parameters
		@Test
		public void shouldReturnExpectedInstanceOfObjectWithGivenPropertyWithDefaultConstructor()
						throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
				ThingWithoutADefaultConstructor thingWithoutADefaultConstructor = new ThingWithoutADefaultConstructor(new SomethingElse());
				iocContainer.get(thingWithoutADefaultConstructor.getClass());
				assertTrue("should not be null", thingWithoutADefaultConstructor != null);
		}


}
