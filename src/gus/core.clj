(ns gus.core)
(require ['clojure.contrib.http.agent :as 'agent])
(require ['clojure.contrib.json :as 'json ])

(def gus-url "https://www.googleapis.com/urlshortener/v1/url?key=")
(defn  gus-key [key] 
	(str key))
(defn shortener [url]
  (json/read-json (agent/string (agent/http-agent
				 (str gus-url gus-key)
				 :method "POST"
				 :body (str "{\"longUrl\":\"" url "\"}" )
				 :headers {"Content-Type" "application/json"}))))
(defn expand [url]
  (json/read-json (agent/string (agent/http-agent
				 (str gus-url gus-key "&shortUrl=" url)))))
(defn analytics [url]
    (json/read-json (agent/string (agent/http-agent
				   (str gus-url gus-key "&projection=FULL&shortUrl=" url)))))

