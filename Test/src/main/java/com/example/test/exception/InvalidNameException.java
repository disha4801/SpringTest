package com.example.test.exception;

public class InvalidNameException extends Exception {

		public InvalidNameException(String msg) {
			super(msg);
		}

		@Override
		public String toString() {
			return super.toString() + super.getMessage();
		}

}
