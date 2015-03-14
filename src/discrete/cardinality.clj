(ns discrete.cardinality)

(defn find-room [bus-num seat-num]
  (let [next-pair (fn [[a b]]
                    (cond
                      (and (= a 1) (= 1 (mod b 2))) [1 (+ b 1)]
                      (and (= b 1) (= 0 (mod a 2))) [(+ a 1) 1]
                      (= 1 (mod (+ a b) 2)) [(+ a 1) (- b 1)]
                      :else [(- a 1) (+ b 1)]))
        find-room-helper (fn [i current-pair]
                           (if (not= current-pair [bus-num seat-num])
                             (recur (+ i 1) (next-pair current-pair))
                             i))]
    (find-room-helper 1 [1 1])))


(defn find-bus-seat [room]
  (let [next-pair (fn [[a b]]
                    (cond 
                      (and (= a 1) (= 1 (mod b 2))) [1 (+ b 1)]
                      (and (= b 1) (= 0 (mod a 2))) [(+ a 1) 1]
                      (= 1 (mod (+ a b) 2)) [(+ a 1) (- b 1)]
                      :else [(- a 1) (+ b 1)]))
        find-bus-seat-helper (fn [i current-pair]
                               (if (not= i room)
                                 (recur (+ 1 i) (next-pair current-pair))
                                 current-pair))]
    (find-bus-seat-helper 1 [1 1])))