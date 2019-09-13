(ns web-test.core-test
  (:require [clojure.test :refer :all]
            [web-test.core :refer :all]))

(deftest route-home
  (testing "Match the home route."
    (let [response (handler {:request-method :get :uri "/"})]
      (is (= 200 (:status response)))
      (is (= "Home" (:body response))))))

(deftest route-not-found
  (testing "Fallback when no route is found."
    (let [response (handler {:request-method :get :uri "/random"})]
      (is (= 404 (:status response)))
      (is (= "Not Found" (:body response))))))