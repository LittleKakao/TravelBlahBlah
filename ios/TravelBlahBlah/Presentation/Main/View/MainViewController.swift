//
//  MainController.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 2023/09/17.
//

import UIKit

class MainViewController: UIViewController, StoryboardInstantiable {

    @IBOutlet weak var createButton: UIButton!
    
    private var viewModel: MainViewModel!
    
    // MARK: - Lifecycle
    
    static func create(
        with viewModel: MainViewModel
    ) -> MainViewController {
        let view = MainViewController.instantiateViewController()
        view.viewModel = viewModel
        
        return view
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        configureUI()
        
    }
    
    // 초기 UI 세팅
    func configureUI() {
    }
    
    // 등록하기 버튼이 눌렸을 때
    @IBAction func createButtonTapped(_ sender: UIButton) {
        viewModel.didTappedButton()
    }
    
}

