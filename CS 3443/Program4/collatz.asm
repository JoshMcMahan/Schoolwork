.data
	name: .asciiz "Joshua McMahan\n"
	message: .asciiz "Please enter a positive integer: "
	linebreak: .asciiz "\n"

.text
	#Prints out my name
	la $a0, name
	addi $v0, $zero, 4
	syscall
	
	#Prints out message
	la $a0, message
	addi $v0, $zero, 4
	syscall
	
	#gets input from the user
	addi $v0, $zero, 5
	syscall
	
	#saves the input into $s0
	add $s0, $zero, $v0
	addi $t0, $zero, 1 
	
	#continue until we reach 1
	while:
	
	#branch if $s0 = 1
	beq $t0, $s0, done
	nop
	#$t1 = $s0 / 2
	addi $t1, $zero, 2
	div $s0, $t1
	mfhi $t1
	
	if:
	# if $t1 == 0 
	bne $t1, $zero, else
	nop
	#move result of earlier division into $s0
	mflo $s0
	#print value of $s0
	add $a0, $zero, $s0
	addi $v0, $zero, 1
	syscall
	#add space
	la $a0, linebreak
	addi $v0, $zero, 4
	syscall
	#return to top of loop
	j while
	nop
	
	#else (if $t1 != 0)
	else:
	#store 3
	addi $t1, $zero, 3
	#3 * $s0
	mult $t1, $s0
	# result of mult stored in $s0
	mflo $s0
	#$s0++
	addi $s0, $s0, 1
	#print value of $s0
	add $a0, $zero, $s0
	addi $v0, $zero, 1
	syscall
	#add space
	la $a0, linebreak
	addi $v0, $zero, 4
	syscall
	#return to top of loop
	j while
	nop
	
	done:
	#stops the program from falling off the end
	addi $v0, $zero, 10
	syscall
