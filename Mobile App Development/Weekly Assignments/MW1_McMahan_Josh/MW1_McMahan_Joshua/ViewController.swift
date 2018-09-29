//
//  ViewController.swift
//  MW1_McMahan_Joshua
//
//  Created by Joshua B McMahan on 9/28/18.
//  Copyright © 2018 Joshua B McMahan. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var laps: UILabel!
    @IBOutlet weak var totalTime: UILabel!
    @IBOutlet weak var lapTime: UILabel!
    
    var userLap:Int = 0
    var nextUserLap:Int = 1
    var timer:Timer!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    
    @IBAction func startStopButton(_ sender: UIButton) {
        let currentState = sender.titleLabel?.text
        
        switch(currentState){
        case "Start":
            sender.setTitle("Stop", for: .normal)
            sender.setTitleColor(.red, for: .normal)
            updateLap()
            break
        case "Stop":
            sender.setTitle("Start", for: .normal)
            sender.setTitleColor(.black, for: .normal)
            break
        default:
            break
        }
    }
    func updateLap() {
            self.userLap = 1
            laps.text = String(userLap)
        
    }
    func nextLapUpdater() {
        
        if nextUserLap >= 1 {
            self.nextUserLap = nextUserLap + 1
            laps.text = String(nextUserLap)
            
        }
    }
        
    
}

