//
//  GameOverViewController.swift
//  W04_McMahan_Josh
//
//  Created by joshua mcmahan on 9/15/18.
//  Copyright © 2018 joshua mcmahan. All rights reserved.
//

import UIKit

class GameOverViewController: UIViewController {
    
    @IBOutlet weak var endScore: UILabel!
    
    var scoreString = "0"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        endScore.text = scoreString
        //self.endScore.text = String(self.scoreNum)
        // Do any additional setup after loading the view.
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
