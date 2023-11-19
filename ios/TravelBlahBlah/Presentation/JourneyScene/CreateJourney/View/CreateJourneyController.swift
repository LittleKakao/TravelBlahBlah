//
//  CreateTravelController.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 2023/10/15.
//

import UIKit

class CreateJourneyController: UIViewController, UITextViewDelegate {
    
    @IBOutlet weak var contryTextField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        configureUI()
        
    }
    
    // 초기 UI 세팅
    func configureUI() {
        
        contryTextField.keyboardType = UIKeyboardType.default
        contryTextField.placeholder = "Where are you going?"
        contryTextField.borderStyle = .roundedRect
        contryTextField.clearButtonMode = .always
        
    }
}
