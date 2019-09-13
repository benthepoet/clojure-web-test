(ns web-test.core)

(require '[ring.util.response :as r])

(defn handler 
  [request]
  (let [method (:request-method request)
        path (:uri request)
        route (list method path)]
    (case route
      ((:get "/")) (r/response "Home")
      (r/not-found "Not Found"))))