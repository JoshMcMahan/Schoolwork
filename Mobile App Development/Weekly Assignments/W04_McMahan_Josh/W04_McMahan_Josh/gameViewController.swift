//
//  gameViewController.swift
//  W04_McMahan_Josh
//
//  Created by joshua mcmahan on 9/14/18.
//  Copyright © 2018 joshua mcmahan. All rights reserved.
//

import UIKit

class gameViewController: UIViewController {

    
    @IBOutlet weak var remainingTime: UILabel!
    @IBOutlet weak var gameIcons: UIImageView!
    @IBOutlet weak var scoreLable: UILabel!
    @IBOutlet weak var scoreNum: UILabel!
    
    var timer:Timer!
    var countDown:Int = 45
    var gameImages: [UIImage] = [#imageLiteral(resourceName: "PinchButton.png"), #imageLiteral(resourceName: "SwipeLeft.png"), #imageLiteral(resourceName: "SwipeRight.png"), #imageLiteral(resourceName: "TapButton.png")]
    var score:Int = 0
    var currentElement:Int = 0
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //calls the countDownAction function
        countDownAction()
        nextGesture()
        
        
        // Do any additional setup after loading the view.
    }

    
    //starts the countdown timer. decreasing the text on the lable by 1 every second
    @objc func countDownAction(){
        timer = Timer.scheduledTimer(withTimeInterval: 1, repeats: true, block: {_ in self.remainingTime.text = String(self.countDown)
            self.countDown = self.countDown - 1
            
            
            
            if self.countDown == 0{
                self.timer.invalidate()
                //After the timer hits 1 sends the user to the game over screen
                self.performSegue(withIdentifier: "toFinalScreen", sender:nil);
            }})
    }
    
    // enables the tapped function calls the nextGesture function
    @IBAction func handleTapped(_ sender: UITapGestureRecognizer) {
        if self.gameIcons.image == gameImages[3]{
            nextGesture()
        }
        
    }
    //enables the swip function and calls the nextGesture function
    @IBAction func handleSwipe(_ sender: UISwipeGestureRecognizer) {
        if self.gameIcons.image == gameImages[1] {
            nextGesture()
        } else if self.gameIcons.image == gameImages[2]{
            nextGesture()
        }
        
    }
    //enables the pinched function calls the nextGesture function
    @IBAction func handlePinched(_ sender: UIPinchGestureRecognizer) {
        if self.gameIcons.image == gameImages[0]{
            nextGesture()
        }
        
    }
    //if the gesture is correct update the score and change the current gesture
    func nextGesture(){
        let randomInt = Int.random(in: 0..<4)
        let previousElement = currentElement
        currentElement = randomInt
        self.gameIcons.image = (self.gameImages[currentElement])
        
        if currentElement == previousElement {
            nextGesture()
        } else {
            updateScore()
            return
            
        }
        //0 is P, 1 is L, 2 is R, 3 is T
        
    }
    //when called updates the current score by 1
    func updateScore(){
        self.scoreNum.text = String(score)
        self.score = score + 1
    }
    // allows the score from the game to be passed to the game over view controller
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let newScore = scoreNum.text
        
        let destination = segue.destination as! GameOverViewController
        destination.scoreString = newScore!
        
    }
    //lets the button return to the prev screen instead of opening more and more view controllers
    @IBAction func handleX(_ sender: UIButton) {
        dismiss(animated: true, completion: nil)
    }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
