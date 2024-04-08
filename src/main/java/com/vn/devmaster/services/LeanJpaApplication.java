package com.vn.devmaster.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeanJpaApplication {

	public LeanJpaApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(LeanJpaApplication.class, args);
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof LeanJpaApplication)) return false;
		final LeanJpaApplication other = (LeanJpaApplication) o;
		if (!other.canEqual((Object) this)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof LeanJpaApplication;
	}

	public int hashCode() {
		int result = 1;
		return result;
	}

	public String toString() {
		return "LeanJpaApplication()";
	}
}
