//
//  testViewModel.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 2023/10/05.
//

import UIKit

protocol CreateJourneyViewModelInput {
    func viewDidLoad()
    func didCancel()
    
}

protocol CreateJourneyViewModelOutput {
    
    var keyBoardType: UIKeyboardType { get }
    var boardStyle: UITextField.BorderStyle { get }
    var clearButtonMode: UITextField.ViewMode { get }
    var contryPlaceHolder: String { get }
    var titlePlaceHolder: String { get }
    
}

typealias CreateJourneyViewModel = CreateJourneyViewModelInput & CreateJourneyViewModelOutput

final class DefaultCreateJourneyViewModel: CreateJourneyViewModel {
    
    // MARK: - OUTPUT
    
    let keyBoardType: UIKeyboardType = .default
    let boardStyle: UITextField.BorderStyle = .roundedRect
    let clearButtonMode: UITextField.ViewMode = .always
    let contryPlaceHolder: String = "Where are you going?"
    let titlePlaceHolder: String = "Title"
    
    // MARK: - Init
    
    init(
    
    ) {
        
    }
    
    // MARK: - Private

    
}

// MARK: - INPUT. View event methods

extension DefaultCreateJourneyViewModel {
    
    func viewDidLoad() {
        
    }
    
    func didCancel() {
        
    }
}
