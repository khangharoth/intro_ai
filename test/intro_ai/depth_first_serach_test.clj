(ns intro-ai.depth-first-serach-test
  (:require [clojure.test :refer :all]
            [intro-ai.depth_first_serach :refer :all]))



(deftest depth_first_serach-test
  (is (= '[:s :d :e :f :g] (findpath  stack) )))
