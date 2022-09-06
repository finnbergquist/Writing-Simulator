# Writing-Simulator

After reading a txt file, this program can simulate the authors writing style. It 
uses markov chains to probabilistically select new characters after each sequence of 
a specified number of characters. For example, if the specified number of characters
was 3, and the program was determining what character to write after tha_, then the
program would likely select t, to complete te word that. This algorithm can also be 
extended to other languages or types of txt such as code.
