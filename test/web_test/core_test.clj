(ns web-test.core-test
  (:require [clojure.test :refer :all]
            [web-test.core :refer :all]))

(defn status-ok? [response] (= 200 (:status response)))
(defn status-not-found? [response] (= 404 (:status response)))

(deftest route-home
  (testing "Match the home route."
    (let [response (handler {:request-method :get :uri "/"})]
      (is (status-ok? response))
      (is (= "Home" (:body response))))))

(deftest route-login
  (testing "Match the login route."
    (let [response (handler {:request-method :post :uri "/login"})]
      (is (status-ok? response))
      (is (= "Login" (:body response))))))

(deftest route-not-found
  (testing "Fallback when no route is found."
    (let [response (handler {:request-method :get :uri "/random"})]
      (is (status-not-found? response))
      (is (= "Not Found" (:body response))))))