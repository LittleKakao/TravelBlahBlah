//
//  CreateTravelController.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 2023/10/15.
//

import UIKit

class CreateJourneyViewController: UIViewController, UITextViewDelegate, StoryboardInstantiable {
    
    @IBOutlet weak var contryTextField: UITextField!
    @IBOutlet weak var titleField: UITextField!
    
    private var viewModel: CreateJourneyViewModel!
    
    // MARK: - Lifecycle
    
    static func create(
        with viewModel: CreateJourneyViewModel
    ) -> CreateJourneyViewController {
        let view = CreateJourneyViewController.instantiateViewController()
        view.viewModel = viewModel
        
        return view
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        configureUI()
        
    }
    
    // MARK: - INPUT
    
    private func configureUI() {
        
        contryTextField.keyboardType = viewModel.keyBoardType
        contryTextField.placeholder = viewModel.contryPlaceHolder
        contryTextField.borderStyle = viewModel.boardStyle
        contryTextField.clearButtonMode = viewModel.clearButtonMode
        
        titleField.keyboardType = viewModel.keyBoardType
        titleField.placeholder = viewModel.titlePlaceHolder
        titleField.borderStyle = viewModel.boardStyle
        titleField.clearButtonMode = viewModel.clearButtonMode
        
    }
}
