//
//  MainController.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 2023/09/17.
//

import UIKit

class MainController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        configureUI()
        
    }
    
    // 초기 UI 세팅
    func configureUI() {
        
    }
    
    // 등록하기 버튼이 눌렸을 때
    @IBAction func createButtonTapped(_ sender: UIButton) {
        let createTravelVC = storyboard?.instantiateViewController(identifier: "createTravelVC") as! CreateTravelController
        
        createTravelVC.modalPresentationStyle = .fullScreen
        
        present(createTravelVC, animated: true, completion: nil)
    }
    
}

