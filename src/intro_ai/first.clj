(ns intro-ai.first
  (:import (clojure.lang PersistentQueue)))


(def tree [1 [2 [4] [5 [7] [8]]] [3  [6]]])


(defn bfs-eager [tree]
  (loop [ret [], queue (conj PersistentQueue/EMPTY tree)]
    (if (seq queue)
      (let [[node & children] (peek queue)]
        (recur (conj ret node) (into (pop queue) children)))
      ret)))

(defn bfs-lazy [tree]
  ((fn step [queue]
     (lazy-seq
       (when (seq queue)
         (let [[node & children] (peek queue)]
           (cons node
                 (step (into (pop queue) children)))))))
    (conj PersistentQueue/EMPTY tree)))


(println (bfs-eager tree))
(println (bfs-lazy tree))