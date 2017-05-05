.data
	name: .asciiz "Joshua McMahan\n"
	prompt: .asciiz "Please enter a word: "
	linebreak: .asciiz "\n"
	array: .space 64
	star: .asciiz "*"
	
.text
	#Prints my name
	la $a0, name
	addi $v0, $zero, 4
	syscall
	
	#Prints the prompt
	la $a0, prompt
	addi $v0, $zero, 4
	syscall
	
	#gets input from the user
	la $a0, array
	addi $a1, $zero, 65
	addi $v0, $zero, 8
	syscall
	
	addi $t0, $zero, 0
	
	#counts how many characters are in the input
	while:
	la $t1, array
	add $t1, $t1, $t0
	lb $t1, 0($t1)
	beq $t1, $zero, afterWhile
	nop
	addi $t0, $t0, 1
	j while
	nop
	
	afterWhile:
	#Save the count + 1
	addi $s0, $t0, 1
	#Counter for the next loop
	addi $t0, $zero, 0
	
	#prints stars according to the size of array
	while2:
	beq $s0, $t0, afterWhile2
	nop
	la $a0, star
	addi $v0, $zero, 4
	syscall
	
	#sets $t0++
	addi $t0, $t0, 1
	j while2
	nop
	
	afterWhile2:
	#prints a linebreak
	la $a0, linebreak
	addi $v0, $zero, 4
	syscall
	
	#prints a star to the left of input
	la $a0, star
	addi $v0, $zero, 4
	syscall
	
	#deletes an extra linebreak
	la $t4, array
	addi $t5, $s0, -2
	add $t4, $t4, $t5
	sb $zero, 0($t4)
	
	#prints the user input
	la $a0, array
	addi $v0, $zero, 4
	syscall
	
	#prints a star to the right of input
	la $a0, star
	addi $v0, $zero, 4
	syscall
	
	#prints a linebreak
	la $a0, linebreak
	addi $v0, $zero, 4
	syscall
	
	addi $t0, $zero, 0
	
	#prints stars according to the size of array
	while3:
	beq $s0, $t0, afterWhile3
	nop
	la $a0, star
	addi $v0, $zero, 4
	syscall
	
	addi $t0, $t0, 1
	j while3
	nop
	
	afterWhile3:
	
	#stops the program from falling off the bottom
	addi $v0, $zero, 10
	syscall
	