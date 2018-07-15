package com.java.newfeature;

@FunctionalInterface
interface Converter<F, T>{
	T convert(F from);
}
