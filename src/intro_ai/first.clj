(ns intro-ai.first
  (:import (clojure.lang PersistentQueue)))


(def graph
  {:s {:a 3 :d 4}
   :a {:s 3 :d 5 :b 4}
   :b {:a 4 :e 5 :c 4}
   :c {:b 4}
   :d {:s 4 :a 5 :e 2}
   :e {:d 2 :b 5 :f 4}
   :f {:e 4 :g 1}})

(def stack [[:s]])

(def goal :g)

(defn findpath [stack]
  (if (not (solved? stack))
    (let [first* (pop* stack) l (last first*) ]
      (findpath (drop-last
                  (remove hasloop?  (lazy-cat
                                      (map #(addtopath first* %)
                                           (keys (l graph))) stack)))))
    [(first stack)]
    )
  )