//
//  testViewModel.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 2023/10/05.
//

import UIKit

struct CreateJourneyViewModelActions {
    
}

protocol CreateJourneyViewModelInput {
    func viewDidLoad()
    func didCancel()
    func didCreate(contry: String, title: String)
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
    
    private let createJourneyUseCase: CreateJourneyUseCase
    private let actions: CreateJourneyViewModelActions?
    
    private var journeyCreateTask: Cancellable? { willSet { journeyCreateTask?.cancel() } }
    private let mainQueue: DispatchQueueType
    
    // MARK: - OUTPUT
    
    let keyBoardType: UIKeyboardType = .default
    let boardStyle: UITextField.BorderStyle = .roundedRect
    let clearButtonMode: UITextField.ViewMode = .always
    let contryPlaceHolder: String = "Where are you going?"
    let titlePlaceHolder: String = "Title"
    
    // MARK: - Init
    
    init(
        createJourneyUseCase: CreateJourneyUseCase,
        actions: CreateJourneyViewModelActions? = nil,
        mainQueue: DispatchQueueType = DispatchQueue.main
    ) {
        self.createJourneyUseCase = createJourneyUseCase
        self.actions = actions
        self.mainQueue = mainQueue
    }
    
    // MARK: - Private

    private func create(contry: String, title: String) {
        
        journeyCreateTask = createJourneyUseCase.execute(requestValue: .init(journeyName: title, journeyDestination: contry), completion: { [weak self] result in
            self?.mainQueue.async {
                switch result {
                case .success(let data):
                    print(data)
                case .failure(let error):
                    print(error)
                }
            }
        })
    }
}

// MARK: - INPUT. View event methods

extension DefaultCreateJourneyViewModel {
    
    func viewDidLoad() {
        
    }
    
    func didCancel() {
        
    }
    
    func didCreate(contry: String, title: String) {
        create(contry: contry, title: title)
    }
}
