# hs-Encryption-Decryption

1. Compile files from you root directory using this command:<br>
	javac .\AlgorithmFactory.java .\AlgorithmStrategy.java .\Main.java 

2. Run Main from parent directory:<br>
	java encryptdecrypt/Main

3. Possible inputs are (omit curly braces) can be written in any order:<br>
	-mode {enc or dec}  // case in-sensitive<br>
	-key {any number}<br>
	-data "{you input}"  // quotes can be omitted if a single word is used otherwise use quotes<br>
	-in {input file to read from}  // must be .txt file<br>
	-out {out put file to write to}  // .txt file if exits, else will be created in project root directory<br>
	-alg {shift or unicode} // which algorithm to use<br>

4.  Default behavior are:<br>
	-mode is set to encryption<br>
	-key 0<br>
	-data is an empty string<br>
	-alg shift<br>
	if both -data and -in supplied, input from -data have higher priority<br>


<a href="https://ibb.co/CnqPJJX"><img src="https://i.ibb.co/FB9Hssf/7n-Xxm-Vn4i-Q.gif" alt="7n-Xxm-Vn4i-Q" border="0"></a>
	
