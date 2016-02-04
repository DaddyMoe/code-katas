package com.mosesmansaray.kata.ioc;

public class Foo {

		private String foo;
		public Foo(){
		}

		public Foo(String s) {
				this.foo = s;
		}

		public String getFoo() {
				return foo;
		}
}


class ThingWithoutADefaultConstructor {
		public ThingWithoutADefaultConstructor(SomethingElse thing) {
		}
}

class SomethingElse {
		public SomethingElse() {

		}
}
