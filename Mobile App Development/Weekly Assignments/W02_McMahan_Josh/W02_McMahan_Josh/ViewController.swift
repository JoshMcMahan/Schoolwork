//
//  ViewController.swift
//  W02_McMahan_Josh
//
//  Created by joshua mcmahan on 8/31/18.
//  Copyright © 2018 joshua mcmahan. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    @IBOutlet weak var numDisplay: UILabel!
    
    
    var totalPressed:[Int] = []
    var total = 0
    
    //handles keypad functions
    @IBAction func keyPad(_ sender: UIButton) {
        let numPressed:Int = Int(sender.titleLabel!.text!)!
        totalPressed.append(numPressed)
        recalculateTotal()
    }
    
    //handles undo button functions
    @IBAction func handleUndo(_ sender: UIButton) {
        if totalPressed.count > 0 {
            totalPressed.removeLast()
            recalculateTotal()
        }
    }
    
    //handles the clear button
    @IBAction func handleClear(_ sender: UIButton) {
        totalPressed.removeAll()
        recalculateTotal()
    }
    
    //handles the recalcultation
    func recalculateTotal() {
        total = totalPressed.reduce(0, +)
        numDisplay.text = String(total)
    }
}

