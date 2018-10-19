//
//  TableViewController.swift
//  W08_McMahan_Joshua
//
//  Created by joshua mcmahan on 10/17/18.
//  Copyright © 2018 joshua mcmahan. All rights reserved.
//
import UIKit
import CoreData

class TableViewController: UITableViewController {
    
    var dataSource: [NSManagedObject] = []
    
    var appDelegate: AppDelegate?
    var context: NSManagedObjectContext?
    var entity: NSEntityDescription?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false
        
        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        appDelegate = UIApplication.shared.delegate as? AppDelegate
        context = appDelegate?.persistentContainer.viewContext
        entity = NSEntityDescription.entity(forEntityName: "Course", in: context!)
    }
    
    @IBAction func unwindFromSave(segue: UIStoryboardSegue) {
        //Get the segue source
        guard let source = segue.source as? ViewController else {
            print("Cannot get unwind segue source")
            return
        }
        
        if let entity = self.entity {
            if checkDuplicateCourse(deptAbbr: source.deptAbbrResult, courseNum: source.courseNumResult) {
                
                
                // Create a new course record
                let course = NSManagedObject(entity: entity, insertInto: context)
                // Set the record attributes
                course.setValue(source.deptAbbrResult, forKey: "deptAbbr")
                course.setValue(source.courseNumResult, forKey: "courseNum")
                course.setValue(source.CourseTitleResult, forKey: "title")
                do {
                    //Update the data store.
                    try context?.save()
                    // Add to data source for table view
                    dataSource.append(course)
                    self.tableView.reloadData()
                } catch let error as NSError {
                    print("Cannot save data: \(error)")
                }
            } else {
                let okAction = UIAlertAction(title: "Duplicate Course", style: .default, handler: nil)
                //create alert controller
                let alertController = UIAlertController(title: "Duplicate Course", message: "This is a duplicate course name", preferredStyle: .alert)
                alertController.addAction(okAction)
                // makes the duplicate alert show after half a second
                DispatchQueue.main.asyncAfter(deadline: .now() + 0.5)
                {self.present(alertController, animated: true, completion: nil)}
            }
        }
    }
    
    
    // MARK: - Table view data source
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return dataSource.count
    }
    
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "My Cell", for: indexPath)
        
        // Configure the cell...
        cell.textLabel?.text = dataSource[indexPath[1]].value(forKey: "deptAbbr") as! String +
            String((dataSource[indexPath[1]]).value(forKey: "courseNum")as! Int16)
        
        cell.detailTextLabel?.text = dataSource[indexPath[1]].value(forKey: "title") as? String
        
        return cell
    }
    //returns false if there is a duplicate course
    func checkDuplicateCourse(deptAbbr: String, courseNum: Int16) -> Bool {
        for course in dataSource {
            let course = course.value(forKey: "deptAbbr") as! String + String(course.value(forKey: "courseNum") as! Int16)
            if course == deptAbbr + String(courseNum) {
                return false
            }
        }
        
        return true
    }
    
    override func viewWillAppear(_ animated: Bool) {
        // Fetch database contents
        let fetchRequest = NSFetchRequest<NSManagedObject>(entityName: "Course")
        do {
            dataSource = try context?.fetch(fetchRequest) ?? []
        } catch let error as NSError {
            print("Cannot load data: \(error)")
        }
        
    }
    
    /*
     // Override to support conditional editing of the table view.
     override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
     // Return false if you do not want the specified item to be editable.
     return true
     }
     */
    
    /*
     // Override to support editing the table view.
     override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
     if editingStyle == .delete {
     // Delete the row from the data source
     tableView.deleteRows(at: [indexPath], with: .fade)
     } else if editingStyle == .insert {
     // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
     }
     }
     */
    
    /*
     // Override to support rearranging the table view.
     override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
     
     }
     */
    
    /*
     // Override to support conditional rearranging of the table view.
     override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
     // Return false if you do not want the item to be re-orderable.
     return true
     }
     */
    
    /*
     // MARK: - Navigation
     
     // In a storyboard-based application, you will often want to do a little preparation before navigation
     override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
     // Get the new view controller using segue.destination.
     // Pass the selected object to the new view controller.
     }
     */
    
}
