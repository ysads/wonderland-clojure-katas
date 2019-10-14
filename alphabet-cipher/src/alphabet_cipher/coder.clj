(ns alphabet-cipher.coder)

(defn char->int
  [c]
  (- (int c) 97))

(defn int->char
  [i]
  (char (+ i 97)))

(defn keyword-char-at
  [keyword position]
  (let [keyword-size (count keyword)
        new-pos      (rem position keyword-size)]
    (.charAt keyword new-pos)))

(defn encoded-char
  [m-char k-char]
  (-> (+ (char->int k-char) (char->int m-char))
      (rem 26)
      (int->char)))

(defn encode
  [keyword message]
  (loop [pos 0
         encoded ""]
    (if (>= pos (count message))
       encoded
       (let [m-char (.charAt message pos)
             k-char (keyword-char-at keyword pos)
             enc-char (encoded-char m-char k-char)]
         (recur (inc pos)
                (str encoded enc-char))))))

(defn decode
  [keyword message]
  "decodeme")

(defn decipher
  [cipher message]
  "decypherme")

