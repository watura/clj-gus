(defproject gus "1.0.0-SNAPSHOT"
  :description "Library for Google URL Shortener"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
		 [com.twinql.clojure/clj-apache-http "2.2.0"]]
  :dev-dependencies [[swank-clojure "1.3.0-SNAPSHOT"]]
  :main gus.core)
