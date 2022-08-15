(ns slva.advent21.day2.part2)

(defrecord State [aim x y])

(defn- calculate-action [acc next]
  (let [amount (:amount next)]
    (case (:direction next)
      :up (update acc :aim - amount)
      :down (update acc :aim + amount)
      :forward (-> (update acc :x + amount)
                   (update :y + (* (:aim acc) amount))))))

(defn calculate [input]
  (let [result (reduce calculate-action (->State 0 0 0) input)]
    (* (:x result) (:y result))))
