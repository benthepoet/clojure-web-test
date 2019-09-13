(ns web-test.core
  (:require [ring.util.response :as r]))

(defn handler 
  [request]
  (let [method (:request-method request)
        path (:uri request)
        route (list method path)]
    (case route
      ((:get "/")) (r/response "Home")
      ((:post "/login")) (r/response "Login")
      (r/not-found "Not Found"))))