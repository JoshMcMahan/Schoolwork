//
//  ViewController.swift
//  Aug28
//
//  Created by joshua mcmahan on 8/28/18.
//  Copyright © 2018 joshua mcmahan. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var myLabel: UILabel!
    
    @IBAction func myButton(_ sender: UIButton) {
        myLabel.text = "Bye bye"
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }


}

