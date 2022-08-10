(ns practicalli.playground
  (:gen-class))

(defn greet
  "Callable entry point to the application."
  [data]
  (str "Hello " (get data :name "World") "!"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (greet {:name (first args)})))
