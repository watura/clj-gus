(ns gus.core)
(require ['clojure.contrib.http.agent :as 'agent])
(require ['clojure.contrib.json :as 'json ])

(def gus-url "https://www.googleapis.com/urlshortener/v1/url?key=")
(defn shortener [url key]
  (json/read-json (agent/string (agent/http-agent
				 (str gus-url key)
				 :method "POST"
				 :body (str "{\"longUrl\":\"" url "\"}" )
				 :headers {"Content-Type" "application/json"}))))
(defn expand [url key]
  (json/read-json (agent/string (agent/http-agent
				 (str gus-url key "&shortUrl=" url)))))
(defn analytics [url key]
    (json/read-json (agent/string (agent/http-agent
				   (str gus-url key "&projection=FULL&shortUrl=" url)))))

