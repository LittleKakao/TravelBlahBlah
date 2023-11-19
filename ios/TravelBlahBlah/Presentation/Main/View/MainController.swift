//
//  MainController.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 2023/09/17.
//

import UIKit

class MainController: UIViewController {

    @IBOutlet weak var createButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        configureUI()
        
    }
    
    // 초기 UI 세팅
    func configureUI() {
    }
    
    // 등록하기 버튼이 눌렸을 때
    @IBAction func createButtonTapped(_ sender: UIButton) {
        let createJourneyVC = storyboard?.instantiateViewController(identifier: "createJourneyVC") as! CreateJourneyController
        
        createJourneyVC.modalPresentationStyle = .fullScreen
        
        present(createJourneyVC, animated: true, completion: nil)
    }
    
}

