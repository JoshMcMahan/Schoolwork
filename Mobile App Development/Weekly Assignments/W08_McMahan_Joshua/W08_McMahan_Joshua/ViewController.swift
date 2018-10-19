//
//  ViewController.swift
//  W08_McMahan_Joshua
//
//  Created by joshua mcmahan on 10/17/18.
//  Copyright © 2018 joshua mcmahan. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet var deptAbbr: UITextField!
    @IBOutlet var courseNum: UITextField!
    @IBOutlet var courseTitle: UITextField!
    
    var deptAbbrResult = " "
    var courseNumResult: Int16 = 0
    var CourseTitleResult = " "
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.deptAbbr.delegate = self
        self.courseNum.delegate = self
        self.courseTitle.delegate = self
        
    }
    
    override func shouldPerformSegue(withIdentifier identifier: String, sender: Any?) -> Bool {
        let deptAbbrNoWhite = deptAbbr.text!.trimmingCharacters(in: .whitespacesAndNewlines )
        let courseNumNoWhite = courseNum.text!.trimmingCharacters(in: .whitespacesAndNewlines )
        let courseTitleNoWhite = courseTitle.text!.trimmingCharacters(in: .whitespacesAndNewlines )
        
        // Check all the text fields and see if they are empty or have newline spaces. If they are display the alert 
        if deptAbbrNoWhite.isEmpty || courseNumNoWhite.isEmpty || courseTitleNoWhite.isEmpty {
            let okAction = UIAlertAction(title: "Empty Fields", style: .default, handler: nil)
            //create alert controller
            let alertController = UIAlertController(title: "Empty Field", message: "You must enter a value for all fields or cancle with the back button", preferredStyle: .alert)
            alertController.addAction(okAction)
            present(alertController, animated: false, completion: nil)
            return false
        } else {
            return true
        }
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        deptAbbrResult = deptAbbr.text ?? "Bad DeptAbbr"
        courseNumResult = Int16(courseNum.text ?? "-1")!
        CourseTitleResult = courseTitle.text ?? "Bad Title"
    }
    
    // Hide keyboard when the user touches outside the keyboard
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    //disable the text field courseNum from taking non numerical input
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        if textField === courseNum {
            return CharacterSet.decimalDigits.isSuperset(of: CharacterSet(charactersIn: string))
        } else {
            return true
        }
    }
    
}
